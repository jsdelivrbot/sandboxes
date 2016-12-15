package com.example;

import io.katharsis.jpa.JpaModule;
import io.katharsis.jpa.JpaRepositoryConfig;
import io.katharsis.jpa.query.Tuple;
import io.katharsis.jpa.query.criteria.JpaCriteriaQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;

@Configuration
public class ModuleConfig {

    @Autowired
    private EntityManager em;

    /**
     * Expose JPA entities as repositories.
     * @return module
     */
    @Bean
    public JpaModule jpaModule() {
        JpaModule module = JpaModule.newServerModule(em, transactionRunner);

        // directly expose entity
        module.addRepository(JpaRepositoryConfig.builder(ScheduleEntity.class).build());

        // additionally expose entity as a mapped dto
        module.addRepository(JpaRepositoryConfig.builder(ScheduleEntity.class, ScheduleDto.class,
                new ScheduleMapper()).build());
        JpaCriteriaQueryFactory queryFactory = (JpaCriteriaQueryFactory) module.getQueryFactory();

        // register a computed a attribute
        // you may consider QueryDSL or generating the Criteria query objects.
        queryFactory.registerComputedAttribute(ScheduleEntity.class, "upperName", String.class,
                new JpaCriteriaExpressionFactory<From<?, ScheduleEntity>>() {

                    @SuppressWarnings({ "rawtypes", "unchecked" })
                    @Override
                    public Expression<String> getExpression(From<?, ScheduleEntity> entity, CriteriaQuery<?> query) {
                        CriteriaBuilder builder = em.getCriteriaBuilder();
                        return builder.upper((Expression) entity.get("name"));
                    }
                });
        return module;
    }

    class ScheduleMapper implements JpaMapper<ScheduleEntity, ScheduleDto> {

        @Override
        public ScheduleDto map(Tuple tuple) {
            ScheduleDto dto = new ScheduleDto();

            // first entry in tuple is the queried entity (if not configured otherwise)
            ScheduleEntity entity = tuple.get(0, ScheduleEntity.class);
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            // computed attribute available as additional tuple entry
            dto.setUpperName(tuple.get(1, String.class));
            return dto;
        }

        @Override
        public ScheduleEntity unmap(ScheduleDto dto) {
            // get entity from database if already there
            ScheduleEntity entity = em.find(ScheduleEntity.class, dto.getId());
            if (entity == null) {
                entity = new ScheduleEntity();
                entity.setId(dto.getId());
            }
            entity.setName(dto.getName());
            return entity;
        }

    }
}

package org.example.repository;

import com.google.common.collect.Iterables;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.*;
import io.katharsis.resource.exception.ResourceNotFoundException;
import org.example.model.Organization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@JsonApiResourceRepository(Organization.class)
public class OrganizationRepository {
    private static final Map<Long, Organization> REPOSITORY = new ConcurrentHashMap<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);

    @JsonApiSave
    public <T extends Organization> T save(T entity) {
        if (entity.getId() == null) {
            entity.setId(ID_GENERATOR.getAndIncrement());
        }
        REPOSITORY.put(entity.getId(), entity);
        return entity;
    }

    @JsonApiFindOne
    public Organization findOne(Long id) {
        Organization org = REPOSITORY.get(id);
        if (org == null) {
            throw new ResourceNotFoundException("Project not found");
        }
        return org;
    }

    @JsonApiFindAll
    public Iterable<Organization> findAll(QueryParams queryParams) {
        return REPOSITORY.values();
    }

    @JsonApiFindAllWithIds
    public Iterable<Organization> findAll(Iterable<Long> iterable, QueryParams queryParams) {
        return REPOSITORY.entrySet()
                .stream()
                .filter(p -> Iterables.contains(iterable, p.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .values();
    }

    @JsonApiDelete
    public void delete(Long id) {
        REPOSITORY.remove(id);
    }
}

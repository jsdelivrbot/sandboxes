package org.example.katharsis;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.katharsis.queryParams.DefaultQueryParamsParser;
import io.katharsis.queryParams.QueryParamsBuilder;
import io.katharsis.servlet.KatharsisProperties;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class KatharsisFeature implements Feature {
    public static final String APPLICATION_URL = "http://localhost:8080";

    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.property(KatharsisProperties.RESOURCE_SEARCH_PACKAGE, "org.example")
                .property(KatharsisProperties.RESOURCE_DEFAULT_DOMAIN, APPLICATION_URL)
                .property(KatharsisProperties.WEB_PATH_PREFIX, "/api")
                .register(new io.katharsis.rs.KatharsisFeature(new ObjectMapper(),
                        new QueryParamsBuilder(new DefaultQueryParamsParser()), new KatharsisServiceLocator()));

        return true;
    }
}

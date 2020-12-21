package utils.aggregators;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import utils.models.AuthUser;

public class TestAuthorizationAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(
            ArgumentsAccessor accessor,
            ParameterContext context
    ) throws ArgumentsAggregationException {
        return new AuthUser(
                accessor.getString(0),
                accessor.getString(1)
        );
    }
}

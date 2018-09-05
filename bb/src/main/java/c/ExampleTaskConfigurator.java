package c;

import com.atlassian.bamboo.task.TaskDefinition;
import com.atlassian.bamboo.collections.ActionParametersMap;
import com.atlassian.bamboo.task.AbstractTaskConfigurator;
import com.atlassian.bamboo.utils.error.ErrorCollection; 
import com.atlassian.bamboo.util.TextProviderUtils;
import com.atlassian.bamboo.util.BambooStringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


public class ExampleTaskConfigurator extends AbstractTaskConfigurator
{
@Override
public Map<String, String> generateTaskConfigMap(@NotNull final ActionParametersMap params, @Nullable final TaskDefinition previousTaskDefinition)
{
    final Map<String, String> config = super.generateTaskConfigMap(params, previousTaskDefinition);

    config.put("say", params.getString("say"));
    config.put("say2", params.getString("say2"));


    return config;
}

public void validate(@NotNull final ActionParametersMap params, @NotNull final ErrorCollection errorCollection)
{
    super.validate(params, errorCollection);

    final String sayValue = params.getString("say");
    final String sayValue2 = params.getString("say2");
   
    if (StringUtils.isEmpty(sayValue))
    {
        errorCollection.addError("say", "Field cannot be empty.");
    }
   
    if (StringUtils.isEmpty(sayValue2))
    {
        errorCollection.addError("say2","Field cannot be empty.");
    }
}
}

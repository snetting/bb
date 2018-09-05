package c;

import com.atlassian.bamboo.build.logger.BuildLogger;
import com.atlassian.bamboo.task.TaskContext;
import com.atlassian.bamboo.task.TaskException;
import com.atlassian.bamboo.task.TaskResult;
import com.atlassian.bamboo.task.TaskResultBuilder;
import com.atlassian.bamboo.task.TaskType;
//import com.mashape.unirest;

public class MyFirstTask implements TaskType
{
    @Override
    public TaskResult execute(final TaskContext taskContext) throws TaskException
    {
        final BuildLogger buildLogger = taskContext.getBuildLogger();
        
        final String say = taskContext.getConfigurationMap().get("say");
        final String say2 = taskContext.getConfigurationMap().get("say2");

        buildLogger.addBuildLogEntry(say.concat(say2));

/*        GetRequest request = Unirest.get("http://google.com");
        buildLogger.addBuildLogEntry(request.getStatusText());
*/
        return TaskResultBuilder.create(taskContext).success().build();
    }
}

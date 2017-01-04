package javaee.generics.mod2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Den on 24.08.2016.
 */
public class ExecutorImpl<T> implements Executor<T> {

    private boolean wasExecuted;

    private Map<Task<? extends T>, Validator<? super T>> taskMap = new HashMap<>();
    private List<T> validResults = new ArrayList<>();
    private List<T> invalidResults = new ArrayList<>();

    @Override
    public void addTask(Task<? extends T> task) throws ExecutorException {
        if(wasExecuted){
            throw new ExecutorException("Tasks have already been executed ");
        }
        taskMap.put(task, null);

    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) throws ExecutorException {
        if(wasExecuted){
            throw new ExecutorException("Tasks have already been executed ");
        }
        taskMap.put(task, validator);

    }

    @Override
    public void execute() {
        for(Map.Entry<? extends Task<? extends T>, ? extends Validator<? super T>> task : taskMap.entrySet()){
            Task<? extends T> taskKey = task.getKey();
            Validator<? super T> taskValue = task.getValue();
            taskKey.execute();
//            validResults.add(taskKey.getResult());
            if (taskValue != null) {
                T result = taskKey.getResult();
                if (taskValue.isValid(result)) {
                    validResults.add(result);
                } else {
                    invalidResults.add(result);
                }
            }
        }
        wasExecuted = true;
    }

    @Override
    public List<T> getValidResults() throws ExecutorException {
        if(!wasExecuted){
            throw new ExecutorException("Execution method has to be invoked");
        }
        return validResults;
    }

    @Override
    public List<T> getInvalidResults() throws ExecutorException {
        if(!wasExecuted){
            throw new ExecutorException("Execution method has to be invoked");
        }
        return invalidResults;
    }
}

package com.sun.hystrixCommand;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import com.sun.model.Student;
import rx.Observable;

public class UserObservableCommand extends HystrixObservableCommand<Student> {

    public UserObservableCommand(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Observable<Student> construct() {
        return null;
    }
}

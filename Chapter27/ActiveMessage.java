package Chapter27;

import Chapter19.Future;

import java.lang.reflect.Method;

public class ActiveMessage {

    private final Object[] objects;
    private final Method method;
    private final ActiveFuture<Object> future;
    private final Object service;

    private ActiveMessage(Builder builder) {
        this.objects = builder.objects;
        this.method = builder.method;
        this.future = builder.future;
        this.service = builder.service;
    }

    public void execute() {
        try {
            Object result = method.invoke(service, objects);
            if (future != null) {
                Future<?> realFuture = (Future<?>)result;
                Object realResult = realFuture.get();
                future.finish(realResult);
            }
        } catch (Exception e) {
            if (future != null) {
                future.finish(null);
            }
        }
    }

    //使用了GoF Builder设计模式
    static class Builder {
        private Object[] objects;
        private Method method;
        private ActiveFuture<Object> future;
        private Object service;

        public Builder userMethod(Method method) {
            this.method = method;
            return this;
        }

        public Builder returnFuture(ActiveFuture<Object> future) {
            this.future = future;
            return this;
        }

        public Builder withObjects(Object[] objects) {
            this.objects = objects;
            return this;
        }

        public Builder forService(Object service) {
            this.service = service;
            return this;
        }

        public ActiveMessage build() {
            return new ActiveMessage(this);
        }
    }
}


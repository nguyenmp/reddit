package com.nguyenmp.reddit.nio;

public abstract class Handler<ResultType> implements Runnable {
    private final Connection<ResultType> connection;

    public Handler(Connection<ResultType> connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            onComplete(connection.call());
        } catch (Exception e) {
            onError(e);
        }
    }
    public abstract void onComplete(ResultType result);
    public abstract void onError(Exception e);
}

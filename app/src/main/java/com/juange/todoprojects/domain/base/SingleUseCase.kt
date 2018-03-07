package com.juange.todoprojects.domain.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/*
This is the core of the architecture

It is based on other of my projects: https://github.com/juange87/JoiningAvengers/blob/master/domain/src/main/java/com/juange/joiningavengers/domain/base/usecase/UseCase.java
 */
abstract class SingleUseCase<T> {

    private var disposable: Disposable? = null

    protected abstract fun buildUseCaseObservable(): Single<T>

    fun execute(observer: DisposableSingleObserver<T>) {
        disposable = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer)
    }

    fun disposeStreams() {
        if (disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}

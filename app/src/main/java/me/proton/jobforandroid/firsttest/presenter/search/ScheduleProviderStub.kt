package me.proton.jobforandroid.firsttest.presenter.search

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import me.proton.jobforandroid.firsttest.presenter.SchedulerProvider

class ScheduleProviderStub : SchedulerProvider {
    override fun ui(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }
}

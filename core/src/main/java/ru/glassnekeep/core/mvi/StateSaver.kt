package ru.glassnekeep.core.mvi

import android.os.Bundle

interface StateSaver<S: State> {
    fun S.toBundle(): Bundle

    fun restore(bundle: Bundle?): S
}
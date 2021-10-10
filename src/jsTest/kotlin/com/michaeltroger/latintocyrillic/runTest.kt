package com.michaeltroger.latintocyrillic

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.promise
import kotlin.coroutines.CoroutineContext

private val testScope = MainScope()
internal actual val testCoroutineContext: CoroutineContext = testScope.coroutineContext
internal actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit): dynamic = testScope.promise { this.block() }
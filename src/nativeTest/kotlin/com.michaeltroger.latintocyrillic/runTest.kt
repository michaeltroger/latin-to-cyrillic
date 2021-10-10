package com.michaeltroger.latintocyrillic

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

internal actual val testCoroutineContext: CoroutineContext = Dispatchers.Main
internal actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit) =
 runBlocking { block() }

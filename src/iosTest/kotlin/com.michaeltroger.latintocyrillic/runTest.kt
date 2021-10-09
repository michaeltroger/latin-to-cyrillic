package com.michaeltroger.latintocyrillic

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext


actual val testCoroutineContext: CoroutineContext = Dispatchers.Main
actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit) =
 runBlocking { this.block() }

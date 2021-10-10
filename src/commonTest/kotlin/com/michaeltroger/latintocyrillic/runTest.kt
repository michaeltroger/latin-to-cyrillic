package com.michaeltroger.latintocyrillic

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

internal expect fun runBlockingTest(block: suspend CoroutineScope.()-> Unit)
internal expect val testCoroutineContext: CoroutineContext
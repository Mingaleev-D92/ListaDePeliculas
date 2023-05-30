package com.example.listadepeliculas.data.common.extensions


import kotlinx.coroutines.CancellationException


/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 * дополнительный блок для ползователького интерфейса
 * } catch (e: HttpException) {
      Result.failure(e)
    }
 */

inline fun <T, R> T.resultOf(block: T.() -> R): Result<R> {
   return try {
      Result.success(block())
   } catch (e: CancellationException) {
      throw e
   } catch (e: Exception) {
      Result.failure(e)
   }
}
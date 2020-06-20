package com.mr_mir.mvvmimlementation.repository

/**
 * Created by Shitab Mir on 20,June,2020
 */

class StatusCheck<T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): StatusCheck<T> {
            return StatusCheck(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(msg: String, data: T? = null): StatusCheck<T> {
            return StatusCheck(
                Status.ERROR,
                data,
                msg
            )
        }

        fun <T> loading(data: T? = null): StatusCheck<T> {
            return StatusCheck(
                Status.LOADING,
                data,
                null
            )
        }
    }

    enum class Status { SUCCESS, ERROR, LOADING }
}
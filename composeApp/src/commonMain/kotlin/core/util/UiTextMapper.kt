package core.util


fun DataError.asUiText(): UiText {


    return UiText.DynamicString(this.toString())
//    return when (this) {
////        DataError.Local.DISK_FULL -> UiText.StringRes(Res.string)
////        DataError.Network.NO_NETWORK -> UiText.StringRes(R.string.no_netowrk)
////        DataError.Network.CONFLICT -> UiText.StringRes(R.string.conflict)
////        DataError.Network.SERIALIZATION_ERROR -> UiText.StringRes(R.string.serialize_error)
////        DataError.Network.UNKNOWN_ERROR -> UiText.StringRes(R.string.unknown_error)
////        DataError.Network.PAYLOAD_TOO_LARGE -> UiText.StringRes(R.string.payload_too_large)
////        DataError.Network.REQUEST_TIMEOUT -> UiText.StringRes(R.string.request_timeout)
////        DataError.Network.TOO_MANY_REQUEST -> UiText.StringRes(R.string.too_many_request)
////        DataError.Network.SERVER_ERROR -> UiText.StringRes(R.string.server_error)
////        DataError.Network.UNAUTHORIZED -> UiText.StringRes(R.string.unAuthed)
////        else -> UiText.StringRes(R.string.unknown_error)
//    }
}
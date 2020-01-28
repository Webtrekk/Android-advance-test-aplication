
import Actions.EVENT_PARAM_SIX
import webtrekk.android.sdk.ParamType
import webtrekk.android.sdk.Webtrekk
import webtrekk.android.sdk.customParam

object Actions {
    val EVENT_PARAM_SIX = customParam(ParamType.EVENT_PARAM, 6);
    const val EVENT_NAME = "event name"
    const val CHANGE_CAMERA = "change camera"
    const val CHANGE_FLASH_SETTING = "change flash setting"
    const val TAKE_PICTURE = "take picture"
    const val OPEN_LATEST_PICTURE = "open latest picture"
    const val ACCESS_CAMERA = "access camera"

}

object Clicks {
    const val CLICK_CAMERA_BUTTON = "click.camera.button"
}

fun tracking(eventParameter: String? = null, eventName: String){
    val params: LinkedHashMap<String, String> = LinkedHashMap()
    if (eventParameter != null) {
        params.put(EVENT_PARAM_SIX, eventParameter)
        Webtrekk.getInstance().trackCustomEvent(eventName, params)

    }
    Webtrekk.getInstance().trackCustomEvent(eventName)

}
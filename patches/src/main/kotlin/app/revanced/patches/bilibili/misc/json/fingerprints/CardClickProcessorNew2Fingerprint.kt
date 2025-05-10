package app.revanced.patches.bilibili.misc.json.fingerprints

import app.revanced.patcher.fingerprint.MethodFingerprint

object CardClickProcessorNew2Fingerprint : MethodFingerprint(
    strings = listOf("tm.recommend.0.0"),
    returnType = "V",
    customFingerprint = { methodDef, _ ->
        methodDef.parameterTypes.let {
            it.size == 7
            && it[1] == "Lcom/bilibili/pegasus/data/FeedbackType;"
            && it[2] == "Lcom/bilibili/pegasus/data/base/BasePegasusData;"
            && it[3] == "Lcom/bilibili/app/comm/list/common/data/DislikeReason;"
            && it[4] == "Ljava/lang/String;"
            && it[5] == "Z"
            && it[6] == "Z"
        }
    }
)

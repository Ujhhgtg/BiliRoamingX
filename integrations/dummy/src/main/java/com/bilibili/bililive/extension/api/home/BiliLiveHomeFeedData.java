package com.bilibili.bililive.extension.api.home;

import android.net.Uri;
import androidx.annotation.Keep;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
/* compiled from: BL */
public final class BiliLiveHomeFeedData {
    @NotNull
    public static final String MODULE_TYPE_ACTIVITY_CARD = "activity_card_v1";
    @NotNull
    public static final String MODULE_TYPE_AREA_ENTRANCE = "area_entrance_v1";
    @NotNull
    public static final String MODULE_TYPE_BANNER_V2 = "banner_v2";
    @NotNull
    public static final String MODULE_TYPE_HOUR_RANK_CARD = "hour_rank_card_v3";
    @NotNull
    public static final String MODULE_TYPE_MY_IDOL = "my_idol_v1";
    @NotNull
    public static final String MODULE_TYPE_SEA_PATROL = "sea_patrol_v1";
    @NotNull
    public static final String MODULE_TYPE_SEA_PATROL_V2 = "sea_patrol_v2";
    @NotNull
    public static final String MODULE_TYPE_SMALL_CARD = "small_card_v1";
    @NotNull
    public static final String MODULE_TYPE_TAB_CARD = "area_entrance_v3";
    @JSONField(serialize = false)
    @Nullable
    private Object cardData;
    @JSONField(name = "card_type")
    @Nullable
    @JvmField
    public String cardType = "";
    @JSONField(name = "card_data")
    @Nullable
    @JvmField
    public CardData pageData;

    private final Object cardData() {
        String str = this.cardType;
        if (str == null) {
            return null;
        }
        CardData cardData;
        switch (str.hashCode()) {
            case -1695837073:
                if (!str.equals(MODULE_TYPE_BANNER_V2)) {
                    return null;
                }
                cardData = this.pageData;
                return cardData != null ? cardData.bannerV2 : null;
            case -961402894:
                if (!str.equals(MODULE_TYPE_AREA_ENTRANCE)) {
                    return null;
                }
                cardData = this.pageData;
                return cardData != null ? cardData.areaEntrance : null;
            case -961402892:
                if (!str.equals(MODULE_TYPE_TAB_CARD)) {
                    return null;
                }
                cardData = this.pageData;
                return cardData != null ? cardData.tabCard : null;
            case 126808143:
                if (!str.equals(MODULE_TYPE_MY_IDOL)) {
                    return null;
                }
                cardData = this.pageData;
                return cardData != null ? cardData.myIdol : null;
            case 529900242:
                if (!str.equals(MODULE_TYPE_SMALL_CARD)) {
                    return null;
                }
                cardData = this.pageData;
                return cardData != null ? cardData.smallCard : null;
            case 829197172:
                if (!str.equals(MODULE_TYPE_HOUR_RANK_CARD)) {
                    return null;
                }
                cardData = this.pageData;
                return cardData != null ? cardData.hourRankCard : null;
            case 994540894:
                if (!str.equals(MODULE_TYPE_SEA_PATROL)) {
                    return null;
                }
                cardData = this.pageData;
                return cardData != null ? cardData.seaPatrol : null;
            case 994540895:
                if (!str.equals(MODULE_TYPE_SEA_PATROL_V2)) {
                    return null;
                }
                cardData = this.pageData;
                return cardData != null ? cardData.seaPatrolV2 : null;
            case 1967093978:
                if (!str.equals(MODULE_TYPE_ACTIVITY_CARD)) {
                    return null;
                }
                cardData = this.pageData;
                return cardData != null ? cardData.activityCard : null;
            default:
                return null;
        }
    }

    @Nullable
    public final Object getCardData() {
        if (this.cardData == null) {
            this.cardData = cardData();
        }
        return this.cardData;
    }

    public final void setCardData(@Nullable Object obj) {
        this.cardData = obj;
    }
}

package com.bilibili.bililive.extension.api.home;

import androidx.annotation.Keep;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
/* compiled from: BL */
public final class BiliLiveHomeFeedPage {
    @JSONField(serialize = false)
    @NotNull
    private List<Object> cardList = new ArrayList();
    @JSONField(name = "has_more")
    @JvmField
    public int hasMore;
    @JSONField(name = "is_need_refresh")
    @JvmField
    public int isNeedRefresh;
    @JSONField(name = "card_list")
    @Nullable
    @JvmField
    public List<BiliLiveHomeFeedData> pageList;
    @JSONField(name = "is_rollback")
    @JvmField
    public int rollback;
    @JSONField(name = "trigger_time")
    @JvmField
    public long triggerTime;

    @NotNull
    public final List<Object> getCardList() {
        if (this.cardList.isEmpty()) {
            this.cardList = feedPageData();
        }
        return this.cardList;
    }

    public final boolean hasMoreData() {
        return this.hasMore == 1;
    }

    public final boolean needAutoRefresh() {
        return this.isNeedRefresh == 1;
    }

    public final boolean needRollback() {
        return this.rollback == 1;
    }

    private final List<Object> feedPageData() {
        ArrayList arrayList = new ArrayList();
        List<BiliLiveHomeFeedData> list = this.pageList;
        if (list != null) {
            for (BiliLiveHomeFeedData cardData : list) {
                Object cardData2 = cardData.getCardData();
                if (cardData2 != null) {
                    arrayList.add(cardData2);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final Object feedPageData(@NotNull String str) {
        List<BiliLiveHomeFeedData> list = this.pageList;
        if (list != null) {
            for (BiliLiveHomeFeedData biliLiveHomeFeedData : list) {
                if (Intrinsics.areEqual(biliLiveHomeFeedData.cardType, str)) {
                    return biliLiveHomeFeedData.getCardData();
                }
            }
        }
        return null;
    }

    public final void setCardList(@NotNull List<Object> list) {
        this.cardList = list;
    }
}

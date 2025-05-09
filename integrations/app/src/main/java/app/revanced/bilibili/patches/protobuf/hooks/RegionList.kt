package app.revanced.bilibili.patches.protobuf.hooks

import app.revanced.bilibili.patches.json.PegasusPatch
import app.revanced.bilibili.settings.Settings
import app.revanced.bilibili.patches.protobuf.MossHook
import com.bapis.bilibili.app.show.mixture.v1.RegionListReply
import com.bapis.bilibili.app.show.mixture.v1.RegionListReq
import com.bapis.bilibili.app.show.mixture.v1.RegionContent
import com.bapis.bilibili.app.show.mixture.v1.RegionIcon
import com.bilibili.lib.moss.api.MossException
import com.google.protobuf.GeneratedMessageLite

object RegionList : MossHook<RegionListReq, RegionListReply>() {
    data class OldPartition(
        val tid: Int,
        val name: String,
        val logo: String,
        val uri: String
    )

    override fun shouldHook(req: GeneratedMessageLite<*, *>): Boolean {
        return Settings.AddOldRegion() && req is RegionListReq
    }

    override fun hookAfter(
        req: RegionListReq,
        reply: RegionListReply?,
        error: MossException?
    ): RegionListReply? {
        val oldPartitions = listOf(
            OldPartition(
                tid = 13,
                name = "番剧",
                logo = "http://i0.hdslb.com/bfs/archive/6f629bd0dcd71d7b9911803f8e4f94fd0e5b4bfd.png",
                uri = "bilibili://pgc/partition_page?page_name=bangumi-operation&title=%E7%95%AA%E5%89%A7&select_id=1"
            ),
            OldPartition(
                tid = 167,
                name = "国创",
                logo = "http://i0.hdslb.com/bfs/archive/1586ec926eac1ea876cb74d32df51394d8e72341.png",
                uri = "bilibili://pgc/partition_page?page_name=gc-operation&title=%E5%9B%BD%E5%88%9B&select_id=1"
            ),
            OldPartition(
                tid = 65545,
                name = "放映厅",
                logo = "http://i0.hdslb.com/bfs/archive/3dfba664353bb2349917eaf81b60db34b2d4c61a.png",
                uri = "bilibili://pgc/cinema"
            ),
            OldPartition(
                tid = 177,
                name = "纪录片",
                logo = "http://i0.hdslb.com/bfs/archive/884a644c6bb4b8bb16f9746ef35fbaba396e0b8c.png",
                uri = "bilibili://pgc/partition_page?page_name=documentary-operation&title=%E7%BA%AA%E5%BD%95%E7%89%87&select_id=1"
            ),
            OldPartition(
                tid = 23,
                name = "电影",
                logo = "http://i0.hdslb.com/bfs/archive/137edde9deb7dfcdf610ed2d1ec63bae6ef3ba0a.png",
                uri = "bilibili://pgc/page/operation_list?page_id=movie-operation&title=%E7%94%B5%E5%BD%B1"
            ),
            OldPartition(
                tid = 11,
                name = "电视剧",
                logo = "http://i0.hdslb.com/bfs/archive/30779a6904875754762e666b7076014528ef4834.png",
                uri = "bilibili://pgc/partition_page?page_name=tv-operation&title=%E7%94%B5%E8%A7%86%E5%89%A7&select_id=1"
            ),
            OldPartition(
                tid = 1,
                name = "动画",
                logo = "http://i0.hdslb.com/bfs/archive/9b3bb8cfc8d87809ffa409bc65def8d8c3eaf72b.png",
                uri = "bilibili://region/1"
            ),
            OldPartition(
                tid = 3,
                name = "音乐",
                logo = "http://i0.hdslb.com/bfs/archive/3a99c51d00038ced3989686b6f3c49d01aa34207.png",
                uri = "bilibili://region/3"
            ),
            OldPartition(
                tid = 129,
                name = "舞蹈",
                logo = "http://i0.hdslb.com/bfs/archive/4769a6faa9ccfde4a029eca36b979bac486afd14.png",
                uri = "bilibili://region/129"
            ),
            OldPartition(
                tid = 4,
                name = "游戏",
                logo = "http://i0.hdslb.com/bfs/archive/9c88ce1adaecf31e27121bdbb5a29824d655d0a6.png",
                uri = "bilibili://region/4"
            ),
            OldPartition(
                tid = 36,
                name = "知识",
                logo = "http://i0.hdslb.com/bfs/archive/d5bb279936dbe661f958683231566214056987b2.png",
                uri = "bilibili://region/36"
            ),
            OldPartition(
                tid = 188,
                name = "科技",
                logo = "http://i0.hdslb.com/bfs/feed-admin/4a687a86b49feea68d423fd1bf2c461acfe59b70.png",
                uri = "bilibili://region/188"
            ),
            OldPartition(
                tid = 202,
                name = "资讯",
                logo = "https://i0.hdslb.com/bfs/legacy/d71e70e1bfcb7b27ffe88e6cb82868c68b084464.png",
                uri = "bilibili://region/202"
            ),
            OldPartition(
                tid = 234,
                name = "运动",
                logo = "http://i0.hdslb.com/bfs/feed-admin/56a67fa38d8d7378ab4154307d26cffce2d1ae3f.png",
                uri = "bilibili://region/234"
            ),
            OldPartition(
                tid = 223,
                name = "汽车",
                logo = "http://i0.hdslb.com/bfs/feed-admin/1515d944550494abf81b552a84484dce80287242.png",
                uri = "bilibili://region/223"
            ),
            OldPartition(
                tid = 160,
                name = "生活",
                logo = "http://i0.hdslb.com/bfs/archive/50731fc4b9ec487ef2e3861a97e0eb4671b7bcef.png",
                uri = "bilibili://region/160"
            ),
            OldPartition(
                tid = 211,
                name = "美食",
                logo = "http://i0.hdslb.com/bfs/archive/0f5e21f08616f9c02d706433ba1c00bd5b889c7b.png",
                uri = "bilibili://region/211"
            ),
            OldPartition(
                tid = 217,
                name = "动物圈",
                logo = "http://i0.hdslb.com/bfs/archive/9f3303b20e12ac874c379da09bca9ce4d0b2f88c.png",
                uri = "bilibili://region/217"
            ),
            OldPartition(
                tid = 65559,
                name = "VLOG",
                logo = "http://i0.hdslb.com/bfs/archive/c794e8220a8cbe3d83b83e76e753c57df67b036a.png",
                uri = "https://www.bilibili.com/h5/vlog?from=2&menu=0"
            ),
            OldPartition(
                tid = 119,
                name = "鬼畜",
                logo = "http://i0.hdslb.com/bfs/archive/de50290b11c65108eb70766fa887032b948d2e4b.png",
                uri = "bilibili://region/119"
            ),
            OldPartition(
                tid = 155,
                name = "时尚",
                logo = "http://i0.hdslb.com/bfs/archive/1842562be5ded346d79312b24fafedbc1d78c8e2.png",
                uri = "bilibili://region/155"
            ),
            OldPartition(
                tid = 5,
                name = "娱乐",
                logo = "http://i0.hdslb.com/bfs/archive/a9bcb4cb7e216c2ea28ba3dc10acd2d210f739bd.png",
                uri = "bilibili://region/5"
            ),
            OldPartition(
                tid = 181,
                name = "影视",
                logo = "http://i0.hdslb.com/bfs/archive/f90bb1ef59630ad9765486c6088a4944b96e88a3.png",
                uri = "bilibili://region/181"
            ),
            OldPartition(
                tid = 65557,
                name = "公开课",
                logo = "http://i0.hdslb.com/bfs/feed-admin/99366a6ea47d7790f57699112bc1d0c6d5f0d302.png",
                uri = "https://www.bilibili.com/h5/mooc?navhide=1"
            ),
            OldPartition(
                tid = 65553,
                name = "活动中心",
                logo = "http://i0.hdslb.com/bfs/archive/3e2e6d338aa8156dc6f63c5dc8c75ed298c5cc9a.png",
                uri = "https://www.bilibili.com/blackboard/x/activity-center-m/index"
            )
        )
        val newContent = RegionContent().apply {
            title = "全部旧版分区"
            oldPartitions.mapIndexed { index, partition ->
                RegionIcon().apply {
                    rid = 2000L + index
                    uniqueId = rid
                    title = partition.name
                    img = partition.logo
                    url = partition.uri
                }
            }.forEach { addIcons(it) }
        }
        val modifiedContents = mutableListOf(newContent)
        modifiedContents.addAll(reply?.contentsList ?: emptyList())
        reply?.clearContents()
        reply?.addAllContents(modifiedContents)
        return super.hookAfter(req, reply, error)
    }
}

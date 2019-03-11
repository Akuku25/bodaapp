package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef extends zzd implements Quest {
    private final int zzadF;
    private final Game zzaiU;

    QuestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.zzaiU = new GameRef(holder, dataRow);
        this.zzadF = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return QuestEntity.zza(this, obj);
    }

    public Quest freeze() {
        return new QuestEntity(this);
    }

    public long getAcceptedTimestamp() {
        return getLong("accepted_ts");
    }

    public Uri getBannerImageUri() {
        return zzbb("quest_banner_image_uri");
    }

    public String getBannerImageUrl() {
        return getString("quest_banner_image_url");
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) zzoZ().get(0);
    }

    public String getDescription() {
        return getString("quest_description");
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zza("quest_description", dataOut);
    }

    public long getEndTimestamp() {
        return getLong("quest_end_ts");
    }

    public Game getGame() {
        return this.zzaiU;
    }

    public Uri getIconImageUri() {
        return zzbb("quest_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("quest_icon_image_url");
    }

    public long getLastUpdatedTimestamp() {
        return getLong("quest_last_updated_ts");
    }

    public String getName() {
        return getString("quest_name");
    }

    public void getName(CharArrayBuffer dataOut) {
        zza("quest_name", dataOut);
    }

    public String getQuestId() {
        return getString("external_quest_id");
    }

    public long getStartTimestamp() {
        return getLong("quest_start_ts");
    }

    public int getState() {
        return getInteger("quest_state");
    }

    public int getType() {
        return getInteger("quest_type");
    }

    public int hashCode() {
        return QuestEntity.zza(this);
    }

    public boolean isEndingSoon() {
        return zzpa() <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return QuestEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((QuestEntity) freeze()).writeToParcel(dest, flags);
    }

    public List<Milestone> zzoZ() {
        List arrayList = new ArrayList(this.zzadF);
        for (int i = 0; i < this.zzadF; i++) {
            arrayList.add(new MilestoneRef(this.zzMd, this.zzNQ + i));
        }
        return arrayList;
    }

    public long zzpa() {
        return getLong("notification_ts");
    }
}

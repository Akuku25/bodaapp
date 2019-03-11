package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] zzaiP = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private int zzLs;
    private String zzacH;
    private String zzaiR;
    private HashMap<Integer, Result> zzajv = new HashMap();

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return zzw.zzk(this).zza("RawScore", Long.valueOf(this.rawScore)).zza("FormattedScore", this.formattedScore).zza("ScoreTag", this.scoreTag).zza("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzLs = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        zzx.zzO(count == 3);
        for (int i = 0; i < count; i++) {
            int zzax = dataHolder.zzax(i);
            if (i == 0) {
                this.zzaiR = dataHolder.zzc("leaderboardId", i, zzax);
                this.zzacH = dataHolder.zzc("playerId", i, zzax);
            }
            if (dataHolder.zzd("hasResult", i, zzax)) {
                zza(new Result(dataHolder.zza("rawScore", i, zzax), dataHolder.zzc("formattedScore", i, zzax), dataHolder.zzc("scoreTag", i, zzax), dataHolder.zzd("newBest", i, zzax)), dataHolder.zzb("timeSpan", i, zzax));
            }
        }
    }

    private void zza(Result result, int i) {
        this.zzajv.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.zzaiR;
    }

    public String getPlayerId() {
        return this.zzacH;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.zzajv.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        zza zza = zzw.zzk(this).zza("PlayerId", this.zzacH).zza("StatusCode", Integer.valueOf(this.zzLs));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.zzajv.get(Integer.valueOf(i));
            zza.zza("TimesSpan", TimeSpan.zzeJ(i));
            zza.zza("Result", result == null ? "null" : result.toString());
        }
        return zza.toString();
    }
}

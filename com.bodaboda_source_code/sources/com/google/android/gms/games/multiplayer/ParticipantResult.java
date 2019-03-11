package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.MatchResult;

public final class ParticipantResult implements SafeParcelable {
    public static final ParticipantResultCreator CREATOR = new ParticipantResultCreator();
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    private final int zzFG;
    private final String zzaeO;
    private final int zzajG;
    private final int zzajH;

    public ParticipantResult(int versionCode, String participantId, int result, int placing) {
        this.zzFG = versionCode;
        this.zzaeO = (String) zzx.zzl(participantId);
        zzx.zzN(MatchResult.isValid(result));
        this.zzajG = result;
        this.zzajH = placing;
    }

    public ParticipantResult(String participantId, int result, int placing) {
        this(1, participantId, result, placing);
    }

    public int describeContents() {
        return 0;
    }

    public String getParticipantId() {
        return this.zzaeO;
    }

    public int getPlacing() {
        return this.zzajH;
    }

    public int getResult() {
        return this.zzajG;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        ParticipantResultCreator.zza(this, out, flags);
    }
}

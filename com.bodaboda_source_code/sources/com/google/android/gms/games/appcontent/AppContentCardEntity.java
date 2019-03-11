package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final String zzFA;
    private final int zzFG;
    private final String zzSy;
    private final String zzZO;
    private final ArrayList<AppContentConditionEntity> zzadk;
    private final String zzadl;
    private final ArrayList<AppContentAnnotationEntity> zzadu;
    private final int zzadv;
    private final String zzadw;
    private final int zzadx;
    private final String zzxV;

    AppContentCardEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentAnnotationEntity> annotations, ArrayList<AppContentConditionEntity> conditions, String contentDescription, int currentProgress, String description, Bundle extras, String subtitle, String title, int totalProgress, String type, String id) {
        this.zzFG = versionCode;
        this.mActions = actions;
        this.zzadu = annotations;
        this.zzadk = conditions;
        this.zzadl = contentDescription;
        this.zzadv = currentProgress;
        this.zzZO = description;
        this.mExtras = extras;
        this.zzFA = id;
        this.zzadw = subtitle;
        this.zzSy = title;
        this.zzadx = totalProgress;
        this.zzxV = type;
    }

    public AppContentCardEntity(AppContentCard card) {
        int i;
        int i2 = 0;
        this.zzFG = 4;
        this.zzadl = card.zzmJ();
        this.zzadv = card.zzmU();
        this.zzZO = card.getDescription();
        this.mExtras = card.getExtras();
        this.zzFA = card.getId();
        this.zzSy = card.getTitle();
        this.zzadw = card.zzmV();
        this.zzadx = card.zzmW();
        this.zzxV = card.getType();
        List actions = card.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = card.zzmT();
        size = actions.size();
        this.zzadu = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzadu.add((AppContentAnnotationEntity) ((AppContentAnnotation) actions.get(i)).freeze());
        }
        List zzmI = card.zzmI();
        int size2 = zzmI.size();
        this.zzadk = new ArrayList(size2);
        while (i2 < size2) {
            this.zzadk.add((AppContentConditionEntity) ((AppContentCondition) zzmI.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzw.hashCode(appContentCard.getActions(), appContentCard.zzmT(), appContentCard.zzmI(), appContentCard.zzmJ(), Integer.valueOf(appContentCard.zzmU()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzmV(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzmW()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzw.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzw.equal(appContentCard2.zzmT(), appContentCard.zzmT()) && zzw.equal(appContentCard2.zzmI(), appContentCard.zzmI()) && zzw.equal(appContentCard2.zzmJ(), appContentCard.zzmJ()) && zzw.equal(Integer.valueOf(appContentCard2.zzmU()), Integer.valueOf(appContentCard.zzmU())) && zzw.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzw.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzw.equal(appContentCard2.getId(), appContentCard.getId()) && zzw.equal(appContentCard2.zzmV(), appContentCard.zzmV()) && zzw.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzw.equal(Integer.valueOf(appContentCard2.zzmW()), Integer.valueOf(appContentCard.zzmW())) && zzw.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzw.zzk(appContentCard).zza("Actions", appContentCard.getActions()).zza("Annotations", appContentCard.zzmT()).zza("Conditions", appContentCard.zzmI()).zza("ContentDescription", appContentCard.zzmJ()).zza("CurrentSteps", Integer.valueOf(appContentCard.zzmU())).zza("Description", appContentCard.getDescription()).zza("Extras", appContentCard.getExtras()).zza("Id", appContentCard.getId()).zza("Subtitle", appContentCard.zzmV()).zza("Title", appContentCard.getTitle()).zza("TotalSteps", Integer.valueOf(appContentCard.zzmW())).zza("Type", appContentCard.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzmX();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public String getDescription() {
        return this.zzZO;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzFA;
    }

    public String getTitle() {
        return this.zzSy;
    }

    public String getType() {
        return this.zzxV;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentCardEntityCreator.zza(this, out, flags);
    }

    public List<AppContentCondition> zzmI() {
        return new ArrayList(this.zzadk);
    }

    public String zzmJ() {
        return this.zzadl;
    }

    public List<AppContentAnnotation> zzmT() {
        return new ArrayList(this.zzadu);
    }

    public int zzmU() {
        return this.zzadv;
    }

    public String zzmV() {
        return this.zzadw;
    }

    public int zzmW() {
        return this.zzadx;
    }

    public AppContentCard zzmX() {
        return this;
    }
}

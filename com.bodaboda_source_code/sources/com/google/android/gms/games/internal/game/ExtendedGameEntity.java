package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
    public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();
    private final int zzFG;
    private final GameEntity zzahV;
    private final int zzahW;
    private final boolean zzahX;
    private final int zzahY;
    private final long zzahZ;
    private final long zzaia;
    private final String zzaib;
    private final long zzaic;
    private final String zzaid;
    private final ArrayList<GameBadgeEntity> zzaie;
    private final SnapshotMetadataEntity zzaif;

    static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
        ExtendedGameEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzcZ(x0);
        }

        public ExtendedGameEntity zzcZ(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(zzh.zziX()) || zzh.zzbf(ExtendedGameEntity.class.getCanonicalName())) {
                return super.zzcZ(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() == 1;
            int readInt2 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString = parcel.readString();
            long readLong3 = parcel.readLong();
            String readString2 = parcel.readString();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(GameBadgeEntity.CREATOR.zzda(parcel));
            }
            return new ExtendedGameEntity(2, gameEntity, readInt, z, readInt2, readLong, readLong2, readString, readLong3, readString2, arrayList, null);
        }
    }

    ExtendedGameEntity(int versionCode, GameEntity game, int availability, boolean owned, int achievementUnlockedCount, long lastPlayedServerTimestamp, long priceMicros, String formattedPrice, long fullPriceMicros, String formattedFullPrice, ArrayList<GameBadgeEntity> badges, SnapshotMetadataEntity snapshot) {
        this.zzFG = versionCode;
        this.zzahV = game;
        this.zzahW = availability;
        this.zzahX = owned;
        this.zzahY = achievementUnlockedCount;
        this.zzahZ = lastPlayedServerTimestamp;
        this.zzaia = priceMicros;
        this.zzaib = formattedPrice;
        this.zzaic = fullPriceMicros;
        this.zzaid = formattedFullPrice;
        this.zzaie = badges;
        this.zzaif = snapshot;
    }

    public ExtendedGameEntity(ExtendedGame extendedGame) {
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        this.zzFG = 2;
        Game game = extendedGame.getGame();
        this.zzahV = game == null ? null : new GameEntity(game);
        this.zzahW = extendedGame.zzoi();
        this.zzahX = extendedGame.zzoj();
        this.zzahY = extendedGame.zzok();
        this.zzahZ = extendedGame.zzol();
        this.zzaia = extendedGame.zzom();
        this.zzaib = extendedGame.zzon();
        this.zzaic = extendedGame.zzoo();
        this.zzaid = extendedGame.zzop();
        SnapshotMetadata zzoq = extendedGame.zzoq();
        if (zzoq != null) {
            snapshotMetadataEntity = new SnapshotMetadataEntity(zzoq);
        }
        this.zzaif = snapshotMetadataEntity;
        ArrayList zzoh = extendedGame.zzoh();
        int size = zzoh.size();
        this.zzaie = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaie.add((GameBadgeEntity) ((GameBadge) zzoh.get(i)).freeze());
        }
    }

    static int zza(ExtendedGame extendedGame) {
        return zzw.hashCode(extendedGame.getGame(), Integer.valueOf(extendedGame.zzoi()), Boolean.valueOf(extendedGame.zzoj()), Integer.valueOf(extendedGame.zzok()), Long.valueOf(extendedGame.zzol()), Long.valueOf(extendedGame.zzom()), extendedGame.zzon(), Long.valueOf(extendedGame.zzoo()), extendedGame.zzop());
    }

    static boolean zza(ExtendedGame extendedGame, Object obj) {
        if (!(obj instanceof ExtendedGame)) {
            return false;
        }
        if (extendedGame == obj) {
            return true;
        }
        ExtendedGame extendedGame2 = (ExtendedGame) obj;
        return zzw.equal(extendedGame2.getGame(), extendedGame.getGame()) && zzw.equal(Integer.valueOf(extendedGame2.zzoi()), Integer.valueOf(extendedGame.zzoi())) && zzw.equal(Boolean.valueOf(extendedGame2.zzoj()), Boolean.valueOf(extendedGame.zzoj())) && zzw.equal(Integer.valueOf(extendedGame2.zzok()), Integer.valueOf(extendedGame.zzok())) && zzw.equal(Long.valueOf(extendedGame2.zzol()), Long.valueOf(extendedGame.zzol())) && zzw.equal(Long.valueOf(extendedGame2.zzom()), Long.valueOf(extendedGame.zzom())) && zzw.equal(extendedGame2.zzon(), extendedGame.zzon()) && zzw.equal(Long.valueOf(extendedGame2.zzoo()), Long.valueOf(extendedGame.zzoo())) && zzw.equal(extendedGame2.zzop(), extendedGame.zzop());
    }

    static String zzb(ExtendedGame extendedGame) {
        return zzw.zzk(extendedGame).zza("Game", extendedGame.getGame()).zza("Availability", Integer.valueOf(extendedGame.zzoi())).zza("Owned", Boolean.valueOf(extendedGame.zzoj())).zza("AchievementUnlockedCount", Integer.valueOf(extendedGame.zzok())).zza("LastPlayedServerTimestamp", Long.valueOf(extendedGame.zzol())).zza("PriceMicros", Long.valueOf(extendedGame.zzom())).zza("FormattedPrice", extendedGame.zzon()).zza("FullPriceMicros", Long.valueOf(extendedGame.zzoo())).zza("FormattedFullPrice", extendedGame.zzop()).zza("Snapshot", extendedGame.zzoq()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzos();
    }

    public /* synthetic */ Game getGame() {
        return zzor();
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

    public void writeToParcel(Parcel dest, int flags) {
        int i = 0;
        if (zziY()) {
            this.zzahV.writeToParcel(dest, flags);
            dest.writeInt(this.zzahW);
            dest.writeInt(this.zzahX ? 1 : 0);
            dest.writeInt(this.zzahY);
            dest.writeLong(this.zzahZ);
            dest.writeLong(this.zzaia);
            dest.writeString(this.zzaib);
            dest.writeLong(this.zzaic);
            dest.writeString(this.zzaid);
            int size = this.zzaie.size();
            dest.writeInt(size);
            while (i < size) {
                ((GameBadgeEntity) this.zzaie.get(i)).writeToParcel(dest, flags);
                i++;
            }
            return;
        }
        ExtendedGameEntityCreator.zza(this, dest, flags);
    }

    public ArrayList<GameBadge> zzoh() {
        return new ArrayList(this.zzaie);
    }

    public int zzoi() {
        return this.zzahW;
    }

    public boolean zzoj() {
        return this.zzahX;
    }

    public int zzok() {
        return this.zzahY;
    }

    public long zzol() {
        return this.zzahZ;
    }

    public long zzom() {
        return this.zzaia;
    }

    public String zzon() {
        return this.zzaib;
    }

    public long zzoo() {
        return this.zzaic;
    }

    public String zzop() {
        return this.zzaid;
    }

    public SnapshotMetadata zzoq() {
        return this.zzaif;
    }

    public GameEntity zzor() {
        return this.zzahV;
    }

    public ExtendedGame zzos() {
        return this;
    }
}

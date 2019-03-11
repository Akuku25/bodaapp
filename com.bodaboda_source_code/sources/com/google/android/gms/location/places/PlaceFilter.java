package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class PlaceFilter implements SafeParcelable {
    public static final zze CREATOR = new zze();
    final int zzFG;
    final boolean zzanC;
    final List<zzj> zzanD;
    final List<String> zzanE;
    private final Set<zzj> zzanF;
    private final Set<String> zzanG;
    final List<Integer> zzany;
    private final Set<Integer> zzanz;

    @Deprecated
    public static final class zza {
        private boolean zzanC;
        private Collection<Integer> zzanH;
        private Collection<zzj> zzanI;
        private String[] zzanJ;

        private zza() {
            this.zzanH = null;
            this.zzanC = false;
            this.zzanI = null;
            this.zzanJ = null;
        }

        public PlaceFilter zzpK() {
            Collection collection = null;
            Collection arrayList = this.zzanH != null ? new ArrayList(this.zzanH) : null;
            Collection arrayList2 = this.zzanI != null ? new ArrayList(this.zzanI) : null;
            if (this.zzanJ != null) {
                collection = Arrays.asList(this.zzanJ);
            }
            return new PlaceFilter(arrayList, this.zzanC, collection, arrayList2);
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int versionCode, List<Integer> placeTypesList, boolean requireOpenNow, List<String> placeIdsList, List<zzj> requestedUserDataTypesList) {
        this.zzFG = versionCode;
        this.zzany = placeTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(placeTypesList);
        this.zzanC = requireOpenNow;
        this.zzanD = requestedUserDataTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(requestedUserDataTypesList);
        this.zzanE = placeIdsList == null ? Collections.emptyList() : Collections.unmodifiableList(placeIdsList);
        this.zzanz = zzn(this.zzany);
        this.zzanF = zzn(this.zzanD);
        this.zzanG = zzn(this.zzanE);
    }

    public PlaceFilter(Collection<Integer> restrictToPlaceTypes, boolean requireOpenNow, Collection<String> restrictToPlaceIds, Collection<zzj> requestedUserDataTypes) {
        this(0, zzc(restrictToPlaceTypes), requireOpenNow, zzc(restrictToPlaceIds), zzc(requestedUserDataTypes));
    }

    public PlaceFilter(boolean requireOpenNow, Collection<String> restrictToPlaceIds) {
        this(null, requireOpenNow, restrictToPlaceIds, null);
    }

    private static <E> List<E> zzc(Collection<E> collection) {
        return (collection == null || collection.isEmpty()) ? Collections.emptyList() : new ArrayList(collection);
    }

    private static <E> Set<E> zzn(List<E> list) {
        return (list == null || list.isEmpty()) ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(list));
    }

    @Deprecated
    public static PlaceFilter zzpJ() {
        return new zza().zzpK();
    }

    public int describeContents() {
        zze zze = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) object;
        return this.zzanz.equals(placeFilter.zzanz) && this.zzanC == placeFilter.zzanC && this.zzanF.equals(placeFilter.zzanF) && this.zzanG.equals(placeFilter.zzanG);
    }

    public Set<String> getPlaceIds() {
        return this.zzanG;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzanz;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanz, Boolean.valueOf(this.zzanC), this.zzanF, this.zzanG);
    }

    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzanC;
    }

    public boolean matches(Place place) {
        if (isRestrictedToPlacesOpenNow() && place.zzpI()) {
            return false;
        }
        Object obj;
        Set placeTypes = getPlaceTypes();
        if (placeTypes.isEmpty()) {
            obj = 1;
        } else {
            for (Integer contains : place.getPlaceTypes()) {
                if (placeTypes.contains(contains)) {
                    int i = 1;
                    break;
                }
            }
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        Set placeIds = getPlaceIds();
        obj = (placeIds.isEmpty() || placeIds.contains(place.getId())) ? 1 : null;
        return obj != null;
    }

    public String toString() {
        com.google.android.gms.common.internal.zzw.zza zzk = zzw.zzk(this);
        if (!this.zzanz.isEmpty()) {
            zzk.zza("types", this.zzanz);
        }
        zzk.zza("requireOpenNow", Boolean.valueOf(this.zzanC));
        if (!this.zzanG.isEmpty()) {
            zzk.zza("placeIds", this.zzanG);
        }
        if (!this.zzanF.isEmpty()) {
            zzk.zza("requestedUserDataTypes", this.zzanF);
        }
        return zzk.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze zze = CREATOR;
        zze.zza(this, parcel, flags);
    }
}

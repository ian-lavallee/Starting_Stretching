package com.mark.v.starting_stretchingv2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ian55 on 2017-12-06.
 */

public class stretch implements Parcelable{
    private String description, image, name;
    private Drawable img;
    private Context context;
    private boolean used;

    public final static Parcelable.Creator<stretch> CREATOR = new Creator<stretch>() {
        @SuppressWarnings({ "unchecked" })
        public stretch createFromParcel(Parcel in) {
            return new stretch(in);
        }

        public stretch[] newArray(int size){
            return (new stretch[size]);
        }
    };

    protected stretch(Parcel in) {
        this.context = ((Context) in.readValue((Context.class.getClassLoader())));
        this.img = ((Drawable) in.readValue((Drawable.class.getClassLoader())));
        this.used = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
    }

    public stretch(Context context, Drawable img, boolean used, String description, String name) {
        this.context = context;
        this.img= img;
        this.name=name;
        this.used = used;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){return name;}

    public boolean getUsed(){
        return used;
    }

    public void setUsed(boolean used){
        this.used=used;
    }

    public Drawable getImage(){
        //   return context.getDrawable(R.drawable.pic2);
        return img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(context);
        dest.writeValue(img);
        dest.writeValue(used);
        dest.writeValue(description);
    }

    public int describeContents() {
        return 0;
    }

 /*   private String description, image;

    private Context context;

    public stretch(Context context) {
        this.context = context;
    }

    public Drawable getImage(){
        return context.getDrawable(R.drawable.pic2);
    }*/

    //Bitmap a = BitmapFactory.decodeFile(imageUri);



/*    public String getImageUri(){
        return imageUri;
    }*/

    //  public Drawable getImage(){
    //      return context.getResources().getDrawable(R.drawable.pic1);
    //  }

}
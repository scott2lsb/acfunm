/*
 * Copyright (C) 2013 YROM.NET
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tv.acfun.video.entity;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * {
     "name":"Part 1",
      "videoId": 779819,
      "sourceId": "119196848",
      "type": "sina",
      "commentId": "119196848"
    }
 * @author Yrom
 *
 */
public class VideoPart implements Parcelable{
    public String name;
    public long videoId;
    public String sourceId;
    public String type;
    public String commentId;
    public List<VideoSegment> segments;
    
    public boolean isDownloaded;
    public boolean isDownloading;
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name == null? "无题":name);
        dest.writeLong(videoId);
        dest.writeString(sourceId);
        dest.writeString(type);
        dest.writeString(commentId);
        dest.writeList(segments);
        dest.writeInt(isDownloaded?1:0);
    }
    public static final Parcelable.Creator<VideoPart> CREATOR = new Creator<VideoPart>() {
        @Override
        public VideoPart[] newArray(int size) {
            
            return new VideoPart[size];
        }
        
        @Override
        public VideoPart createFromParcel(Parcel source) {
            VideoPart part = new VideoPart();
            part.name = source.readString();
            part.videoId = source.readLong();
            part.sourceId = source.readString();
            part.type = source.readString();
            part.commentId = source.readString();
            part.segments = source.readArrayList(getClass().getClassLoader());
            part.isDownloaded = source.readInt() == 1;
            return part;
        }
    };
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        VideoPart other = (VideoPart) obj;
        if (sourceId == null) {
            if (other.sourceId != null) return false;
        } else if (!sourceId.equals(other.sourceId)) return false;
        if (type == null) {
            if (other.type != null) return false;
        } else if (!type.equals(other.type)) return false;
        return true;
    }
    
}

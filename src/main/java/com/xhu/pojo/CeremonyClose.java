package com.xhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CeremonyClose {

    private String ceremonyId;
    private String ceremonyName;
    private String ceremonyStartTime;
    private String ceremonyEndTime;
    private String ceremonyPlace;
    private String ceremonyHost;
}

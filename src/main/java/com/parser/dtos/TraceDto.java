package com.parser.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraceDto implements Comparable<TraceDto>{
    private JsonPayloadDto jsonPayload;
    private Date timestamp;

    @Override
    public int compareTo(TraceDto o) {
        return getTimestamp().compareTo(o.getTimestamp());
    }
}

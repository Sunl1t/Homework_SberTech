package Sunlit.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StreamContainer {

    private String name;
    private long count;

    @Override
    public String toString(){
        return "StreamContainer [name=" + name + ", count=" + count + "]";
    }
}

package apibase.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {

    private int total;
    private int pages;
    private int page_size;
    private int current_page;

    Paging() {
    }

}

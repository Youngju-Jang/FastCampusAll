package org.example.wasPractice;

import org.example.wasPractice.QueryStrings;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueryStringsTest {

    @Test
    void createTest() {
        QueryStrings queryStrings = new QueryStrings("operand=11&operator=*&operand2=55"); // List<QueryStrings>

        assertThat(queryStrings).isNotNull();
    }
}
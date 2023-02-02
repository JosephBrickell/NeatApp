package com.Neat.Factory;

import java.io.IOException;
import java.util.List;

public interface Website {

    public List<String> fetchIngregients(String url) throws IOException;

    public List<String> fetchMethod(String url) throws IOException;


}

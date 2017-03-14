package factories;

import java.util.List;

public interface IJokeFactory {
    List<IJokeFetcher> getJokeFetchers(JokeType.type[] types);
}

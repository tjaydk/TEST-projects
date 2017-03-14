package factories;

import java.util.List;

public interface IFetcherFactory {
    List<IJokeFetcher> getJokeFetchers(JokeType[] types);
}

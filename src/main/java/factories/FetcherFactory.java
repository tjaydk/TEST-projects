package factories;

import java.util.ArrayList;
import java.util.List;

public class FetcherFactory implements IFetcherFactory {


    @Override
    public List<IJokeFetcher> getJokeFetchers(JokeType[] types) {

        List<IJokeFetcher> fetchers = new ArrayList<>();

        for (JokeType type : types) {
            switch (type) {
                case CHUCKNORRIS:
                    fetchers.add(new ChuckNorrisFetcher());
                    break;
                case EDUPROG:
                    fetchers.add(new EduProgFetcher());
                    break;
                case TAMBAL:
                    fetchers.add(new TambalFetcher());
                    break;
                case YOMAMMA:
                    fetchers.add(new YoMammaFetcher());
                    break;
                default:
                    break;
            }
        }

        return fetchers;

    }
}

package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    OriginalRetriever originalRetriever;
    LRUCache<Long, Object> lruCache = new LRUCache(100);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object retrieve = lruCache.find(id);
        if (retrieve == null) {
            retrieve = originalRetriever.retrieve(id);
            lruCache.set(id, retrieve);
        }
        return retrieve;
    }
}

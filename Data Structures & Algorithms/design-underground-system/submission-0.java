class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkInMap;
    Map<String, long[]> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = checkInMap.get(id);
        String route = pair.getKey() + "," + stationName;
        routeMap.putIfAbsent(route, new long[]{0, 0});
        routeMap.get(route)[0] += t - pair.getValue();
        routeMap.get(route)[1] += 1;
    }

    public double getAverageTime(String startStation, String endStation) {
        long[] data = routeMap.get(startStation + "," + endStation);
        return (double) data[0] / data[1];
    }

}

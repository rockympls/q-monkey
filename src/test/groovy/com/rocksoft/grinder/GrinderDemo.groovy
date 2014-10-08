package com.rocksoft.grinder

class GrinderDemo {

  static void main(String[] args) {
    GrinderQ<String> q = new GrinderQ<>(21, DemoConsumer)
    (1..1000).each { i ->
      q.offer('foobar' + i)
    }
    q.start(Pulse.EXTRA_FAST, 100L)
    Thread.sleep(1000L)

    assert DemoConsumer.count == 1000
  }

  static class DemoConsumer implements GrinderConsumer<String> {
    static int count
    void consume(String item) {
      count++
    }
  }
}
package otus202505

import io.gatling.core.Predef.{Simulation, _}

class DebugOtus extends Simulation{
//  setUp(OtusScenario()
//    .inject(rampUsers(300)
//      .during(120)))
//    .protocols(otus.httpProtocol)
//    .assertions(forAll.failedRequests.percent.lte(5))
//    .assertions(forAll.responseTime.max.lt(3000))
//    setUp(OtusScenario()
//      .inject(atOnceUsers(1)))
//      .protocols(otus.httpProtocol)
//      .assertions(forAll.failedRequests.percent.lte(5))

  setUp(OtusScenario()
    .inject(incrementUsersPerSec(1)
      .times(4)
      .eachLevelLasting(10)
      .separatedByRampsLasting(4)
      .startingFrom(1)))
    .protocols(otus.httpProtocol)
    .assertions(forAll.failedRequests.percent.lte(5))
    .assertions(forAll.responseTime.max.lt(3000))

//    setUp(OtusScenario()
//      .inject(
//        rampUsersPerSec(0).to(9)
//          .during(30)))
//      .protocols(otus.httpProtocol)
//      .assertions(forAll.failedRequests.percent.lte(5))
//      .assertions(forAll.responseTime.max.lt(3000))


//  setUp(OtusScenario()
//    .inject(
//      rampUsersPerSec(0).to(9)
//        .during(30),
//      constantUsersPerSec(9)
//      .during(96),
//      rampUsersPerSec(9).to(18)
//        .during(30)
//      constantUsersPerSec(18)
//        .during(96),
//      rampUsersPerSec(18).to(27)
//        .during(30),
//      constantUsersPerSec(27)
//        .during(96),
//      rampUsersPerSec(27).to(36)
//        .during(30),
//      constantUsersPerSec(36)
//        .during(96),
//      rampUsersPerSec(36).to(45)
//        .during(30),
//      constantUsersPerSec(45)
//        .during(96),
//      rampUsersPerSec(45).to(54)
//        .during(30),
//      constantUsersPerSec(54)
//        .during(96),
//      rampUsersPerSec(54).to(63)
//        .during(30),
//      constantUsersPerSec(63)
//        .during(96),
//      rampUsersPerSec(63).to(72)
//        .during(30),
//      constantUsersPerSec(72)
//        .during(96),
//      rampUsersPerSec(72).to(81)
//        .during(30),
//      constantUsersPerSec(81)
//        .during(96),
//      rampUsersPerSec(81).to(90)
//        .during(30),
//      constantUsersPerSec(80)
//        .during(96)
//    ))
//    .protocols(otus.httpProtocol)
//    .assertions(forAll.failedRequests.percent.lte(5))
//    .assertions(forAll.responseTime.max.lt(3000))

}


//scn.inject(
//  rampUsers(300)
//    .during(120)
//)
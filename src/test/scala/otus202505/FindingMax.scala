package otus202505

import io.gatling.core.Predef.{Simulation, _}

class FindingMax extends Simulation{

//    setUp(OtusScenario()
//      .inject(atOnceUsers(1)))
//      .protocols(otus.httpProtocol)
//      .assertions(forAll.failedRequests.percent.lte(5))




  setUp(OtusScenario()
    .inject(incrementUsersPerSec(5.0)
      .times(6)
      .eachLevelLasting(300)
      .separatedByRampsLasting(20)
      startingFrom(50)))
    .protocols(otus.httpProtocol)
    .assertions(forAll.failedRequests.percent.lte(5))
    .assertions(forAll.responseTime.max.lt(3000))

//  setUp(
//    OtusScenario()
//      .inject(rampUsersPerSec(0).to(10)
//      .during(30),
//      constantUsersPerSec(10)
//        .during(600)))
//    .protocols(otus.httpProtocol)
//    .assertions(forAll.failedRequests.percent.lte(5))
//    .assertions(forAll.responseTime.max.lt(3000))

//    setUp(OtusScenario()
//      .inject(
//        rampUsersPerSec(0).to(9)
//          .during(30)))
//      .protocols(otus.httpProtocol)
//      .assertions(forAll.failedRequests.percent.lte(5))
//      .assertions(forAll.responseTime.max.lt(3000))
}


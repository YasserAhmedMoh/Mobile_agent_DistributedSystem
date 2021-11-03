# Mobile_agent_DistributedSystem



[![Build Status](https://img.shields.io/badge/Java-100%25-green)](https://travis-ci.org/joemccann/dillinger) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[![Build Status](https://img.shields.io/badge/commit%20activity-1weeks-blue)](https://travis-ci.org/joemccann/dillinger) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br />

1.	There are 3 nodes in the system:<br />
•	Sensors, surveillance, cameras nodes<br />
•	server nodes<br />
•	driver nodes<br /><br />
Role of mobile agents transfer the readings and photo sensor, cameras
nodes to server nodes in each area, process them based on a global view of the traffic in the whole city & once the results after process are ready,
they will transfer the recommendations to driver nodes about best street.


## steps to run program: <br />
1-	open and run server<br />
2-	open and run intermediate so we will see in server terminal that it is assigning new thread and intermediate will sleep for 5000 second to let two client open<br />
3-	Open Client_Sensor and run it<br />
4-	Open Client_driver and run it <br />
We will see that data transfer between server and client throw intermediate.<br />





## ALP
<p align="center">
  <img alt="gif" src="https://github.com/YasserAhmedMoh/Mobile_agent_DistributedSystem/blob/main/Picture1.png" />
<p>

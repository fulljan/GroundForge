/*
 Copyright 2015 Jo Pol
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program. If not, see http://www.gnu.org/licenses/gpl.html dibl
*/
package dibl

import org.scalatest._

import scala.collection.immutable.HashMap

class GraphSpec extends FlatSpec with Matchers {
  "default graph" should "produce nodes and links" in {
    val nodesPerTile = 6
    val sourcesPerNode = 2
    val tileRows = 6
    val tileColumns = 3

    val data = Graph.getData()
    data.nodes.length should equal (16*16)
    data.links.length should equal(nodesPerTile * sourcesPerNode * tileRows * tileColumns)
  }
}
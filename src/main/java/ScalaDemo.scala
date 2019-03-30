import utils.TreeNode
import scala.collection.mutable

object ScalaDemo {

  def singleNumber(nums: Array[Int]): Array[Int] = {
    var xor = 0
    nums.foreach(xor^=_)
    xor = xor & (-xor)
    val res = Array[Int](0, 0)
    nums.foreach{num=>
      if((num&xor)==1) {
        res(0) ^= num
      }
      else {
        res(1) ^= num
      }
    }
    res
  }
}

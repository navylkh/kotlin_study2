package com.hoony.kr.sendobject

import android.os.Parcel
import android.os.Parcelable

class TestClass : Parcelable {

    var data10 : Int = 0
    var data20 : String? = null

    companion object {
        /**
         * Intent로부터 객체를 추출해올 때 호출
         */
        @JvmField
        val CREATOR : Parcelable.Creator<TestClass> = object : Parcelable.Creator<TestClass>{
            override fun createFromParcel(source: Parcel?): TestClass {
                val test = TestClass()
                test.data10 = source?.readInt()!!
                test.data20 = source?.readString()

                return test
            }

            override fun newArray(size: Int): Array<TestClass?> {
                return arrayOfNulls<TestClass>(size)
            }
        }
    }

    /**
     * 멤버의 순서에 맞게 write 해야 한다.
     * 객체를 전달하는 시점에 호출
     * Intent에 객체를 담을 때 호출
     */
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(data10)
        dest?.writeString(data20)
    }

    override fun describeContents(): Int {
        return 0
    }
}
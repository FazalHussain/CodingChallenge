package com.example.fazal.codingchalenge.Models.response

import android.content.ClipData
import com.example.fazal.codingchalenge.Models.data.Item
import com.example.fazal.codingchalenge.Models.data.Items
import com.example.fazal.codingchalenge.Models.data.SectionRole
import com.example.fazal.codingchalenge.Models.data.WorkerData

data class WorkerResponse(var message: String, var data: WorkerData) {

    /**
     * Populate the hash map according to their role
     *
     * @return The [HashMap<String, List<Items>] object.
     */
    fun populateHashMap(items: List<Items>) : HashMap<String, ArrayList<Items>> {
        val hashMap = HashMap<String, ArrayList<Items>>()
        var list: ArrayList<Items>
        items.forEach{
                if (hashMap.containsKey(it.attributes!!.role!!)) {
                    list = hashMap[it.attributes!!.role]!!
                    list.add(it)
                    it.attributes?.role?.let { role ->
                        hashMap[role] = list
                    }
                } else {
                    list = ArrayList()
                    list.add(it)
                    it.attributes?.role?.let { role ->
                        hashMap[role] = list
                    }

                }

            }

        return hashMap

    }

    /**
     * Populate the list of item according to role.
     *
     * See also [populateHashMap]
     *
     * @return The collection of items
     *
     */
    fun populateList(items: List<Items>) : ArrayList<Item> {
        val map = populateHashMap(items)
        val list = ArrayList<Item>()
        map.forEach{ item ->
            list.add(SectionRole(item.key))
            val itemsAccordingToRole = item.value
            itemsAccordingToRole.forEach{
                list.add(it)
            }
        }

        return list

    }
}

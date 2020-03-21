package octo.dao

import octo.model.IssueEvent
import org.litote.kmongo.find
import org.litote.kmongo.getCollection

class IssueEventDAO {

    private val issueEventCollection = DBConnection.getInstance().getCollection<IssueEvent>()

    fun insert(issue: IssueEvent) : IssueEvent {
        return issue.apply { issueEventCollection.insertOne(issue) }
    }

    fun getByIssueId(id: Int) : List<IssueEvent> {
        return issueEventCollection.find("{ \"issue.id\": $id}").toList<IssueEvent>()
    }
}
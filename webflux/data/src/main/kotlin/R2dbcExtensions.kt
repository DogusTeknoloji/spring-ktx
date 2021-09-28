import com.dteknoloji.utility.core.getOrNull
import io.r2dbc.postgresql.api.PostgresqlException
import org.springframework.dao.DataIntegrityViolationException

fun DataIntegrityViolationException.handleConstraints(block: (String) -> Nothing): Nothing {
    val constraint = (cause as PostgresqlException).errorDetails.constraintName.getOrNull() ?: throw this
    block(constraint)
}

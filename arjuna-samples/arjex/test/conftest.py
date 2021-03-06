import pytest

from arjuna.engine.pytest import PytestHooks


try:
    from arjex.lib.resource import *
except ModuleNotFoundError as e:
    if e.name not in {"arjex.lib", "arjex.lib.resource"}:
        raise Exception(e.name)

@pytest.mark.hookwrapper
def pytest_runtest_makereport(item, call):
    result = yield
    PytestHooks.prepare_result(result)
    PytestHooks.enhance_reports(item, result)


def pytest_html_report_title(report):
    PytestHooks.set_report_title(report)

def pytest_configure(config):
    PytestHooks.add_env_data(config)

def pytest_generate_tests(metafunc):
    PytestHooks.configure_group_for_test(metafunc)

def pytest_collection_modifyitems(items, config):
    PytestHooks.select_tests(items, config)

def pytest_html_results_summary(prefix, summary, postfix):
    PytestHooks.inject_arjuna_js(prefix)